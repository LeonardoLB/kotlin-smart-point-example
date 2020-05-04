package leonardobufalo.example.pontointeligente.services.impl

import leonardobufalo.example.pontointeligente.documents.Empresa
import leonardobufalo.example.pontointeligente.repositories.EmpresaRepository
import leonardobufalo.example.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? {
        return empresaRepository.findByCnpj(cnpj)
    }

    override fun persisitirEmpresa(empresa: Empresa): Empresa {
        return empresaRepository.save(empresa)
    }

}