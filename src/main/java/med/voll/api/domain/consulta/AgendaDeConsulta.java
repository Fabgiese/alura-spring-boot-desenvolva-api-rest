package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {
        System.out.println(dados);
        if(!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente não existe.");
        }
        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico não existe.");
        }
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolherMedico(dados);
        var consulta = new Consulta(null, medico, paciente, dados.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if(dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null) {
            throw new ValidationException("Precisa escolher uma especialidade se não existir médico de preferencia!");
        }

        return medicoRepository.getMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelar(DadosCancelamentoConsulta dadosCancelamentoConsulta) {
        if(!consultaRepository.existsById(dadosCancelamentoConsulta.idConsulta())){
            throw new ValidacaoException("Id da consulta informada não existe.");
        }
        var consulta = consultaRepository.getReferenceById(dadosCancelamentoConsulta.idConsulta());
        consulta.cancelar(dadosCancelamentoConsulta.motivo());
    }
}
