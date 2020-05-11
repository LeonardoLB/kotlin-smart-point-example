package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Funcionario
import java.util.*

interface FuncionarioService {

    fun persistir(funcionario: Funcionario): Funcionario? = null

    fun bucarPorCpf(cpf: String): Funcionario? = null

    fun buscarPorEmail(email: String): Funcionario? = null

    fun buscarPorId(id: String): Funcionario? = null
}