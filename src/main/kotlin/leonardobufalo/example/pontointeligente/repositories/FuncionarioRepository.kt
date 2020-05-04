package leonardobufalo.example.pontointeligente.repositories

import leonardobufalo.example.pontointeligente.documents.Funcionario
import org.springframework.data.mongodb.repository.MongoRepository

interface FuncionarioRepository : MongoRepository<Funcionario, String> {

    fun FindByEmail(email: String): Funcionario

    fun findByCpf(cpf: String): Funcionario

}