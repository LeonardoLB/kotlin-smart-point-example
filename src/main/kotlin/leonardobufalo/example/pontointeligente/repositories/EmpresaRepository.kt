package leonardobufalo.example.pontointeligente.repositories

import leonardobufalo.example.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cnpj: String): Empresa

}