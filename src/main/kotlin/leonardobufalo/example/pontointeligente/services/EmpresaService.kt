package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persisitirEmpresa(empresa: Empresa): Empresa

}