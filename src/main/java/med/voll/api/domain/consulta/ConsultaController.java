package med.voll.api.domain.consulta;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @Autowired
    private AgendaDeConsulta agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        agenda.agendar(dadosAgendamentoConsulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

}
