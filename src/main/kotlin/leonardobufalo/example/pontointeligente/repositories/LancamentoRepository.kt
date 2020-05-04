package leonardobufalo.example.pontointeligente.repositories

import leonardobufalo.example.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface LancamentoRepository : MongoRepository<Lancamento, String> {

    fun FindByFuncionarioId(funcionarioId: String, pageable: Pageable): Page<Lancamento>

}