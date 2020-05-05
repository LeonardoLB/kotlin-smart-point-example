package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Empresa
import leonardobufalo.example.pontointeligente.repositories.EmpresaRepository
import leonardobufalo.example.pontointeligente.services.impl.EmpresaServiceImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EmpresaServiceTest {

    @InjectMocks
    private lateinit var empresaServiceImpl: EmpresaServiceImpl

    @Mock
    private lateinit var empresaRepository: EmpresaRepository

    private val CNPJ = "00066370000121"

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)

        given(empresaRepository.findByCnpj(CNPJ)).willReturn(empresa())
        given(empresaRepository.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testBucarEmpresaPorCnpj() {
        val empresa: Empresa? = empresaServiceImpl?.buscarPorCnpj(CNPJ)
        Assert.assertEquals(empresa() ,empresa)
    }

    @Test
    fun testPersistirEmpresa() {
        val empresa: Empresa? = empresaServiceImpl?.persisitirEmpresa(empresa())
        Assert.assertEquals(empresa(), empresa)
    }

    private fun empresa(): Empresa {
        return Empresa("Teste SA", CNPJ, "1")
    }

}