package med.voll.api.domain.consulta;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {


    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        System.out.println(dadosAgendamentoConsulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

}
