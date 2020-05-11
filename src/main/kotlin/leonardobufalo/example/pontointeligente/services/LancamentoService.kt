package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Lancamento
import leonardobufalo.example.pontointeligente.repositories.LancamentoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface LancamentoService {

    fun bucarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>

    fun buscarPorId(id: String): Lancamento?

    fun persisitir(lancamento: Lancamento): Lancamento

    fun remover(id: String)

}