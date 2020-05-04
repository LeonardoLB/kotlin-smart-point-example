package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Empresa
import leonardobufalo.example.pontointeligente.repositories.EmpresaRepository
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class EmpresaServiceTest {

    @Autowired
    val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "00066370000121"

    @Before
    @Throws(Exception::class)
    fun setUp(){
            BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
            BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testBucarEmpresaPorCnpj() {
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
        Assert.assertNotNull(empresa)
    }

    @Test
    fun testPersistirEmpresa() {
        val empresa: Empresa? = empresaService?.persisitirEmpresa(empresa())
        Assert.assertEquals(empresa(), empresa)
    }

    private fun empresa(): Empresa {
        return Empresa("Teste SA", CNPJ, "1")
    }

}