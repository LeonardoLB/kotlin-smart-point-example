package leonardobufalo.example.pontointeligente.services.impl

import leonardobufalo.example.pontointeligente.documents.Lancamento
import leonardobufalo.example.pontointeligente.repositories.LancamentoRepository
import leonardobufalo.example.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun bucarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> {
        return lancamentoRepository.FindByFuncionarioId(funcionarioId, pageRequest)
    }

    override fun buscarPorId(id: String): Lancamento? {
        return lancamentoRepository.findById(id).orElse(null)
    }

    override fun persisitir(lancamento: Lancamento): Lancamento {
        return lancamentoRepository.save(lancamento)
    }

    override fun remover(id: String) {
        return lancamentoRepository.deleteById(id)
    }


}