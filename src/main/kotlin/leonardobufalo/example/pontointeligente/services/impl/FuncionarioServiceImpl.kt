package leonardobufalo.example.pontointeligente.services.impl

import leonardobufalo.example.pontointeligente.documents.Funcionario
import leonardobufalo.example.pontointeligente.repositories.FuncionarioRepository
import leonardobufalo.example.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario {
        return funcionarioRepository.save(funcionario)
    }

    override fun bucarPorCpf(cpf: String): Funcionario? {
        return funcionarioRepository.findByCpf(cpf)
    }

    override fun buscarPorEmail(email: String): Funcionario? {
        return funcionarioRepository.FindByEmail(email)
    }

    override fun buscarPorId(id: String): Funcionario? {
        return funcionarioRepository.findById(id).orElse(null)
    }

}