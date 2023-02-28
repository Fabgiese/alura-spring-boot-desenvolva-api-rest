package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import med.voll.api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @Autowired
    private AgendaDeConsulta agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta) throws ValidacaoException {
        agenda.agendar(dadosAgendamentoConsulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dadosCancelamentoConsulta){
        agenda.cancelar(dadosCancelamentoConsulta);
        return ResponseEntity.noContent().build();
    }

}
