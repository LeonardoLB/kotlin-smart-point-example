package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.documents.Lancamento
import leonardobufalo.example.pontointeligente.enums.TipoEnum
import leonardobufalo.example.pontointeligente.repositories.LancamentoRepository
import leonardobufalo.example.pontointeligente.services.impl.LancamentoServiceImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import java.util.*
import kotlin.collections.ArrayList

@SpringBootTest
class LancamentoServiceTest {

    @InjectMocks
    private lateinit var lancamentoServiceImpl: LancamentoServiceImpl

    @Mock
    private lateinit var  lancamentoRepository: LancamentoRepository

    val ID = "1"
    val DATE = Date()
    val DESCRICAO = "descricao"
    val LOCAL = "SP"

    val lancamentoMock: Lancamento = Lancamento(
            date = DATE,
            tipo = TipoEnum.INICIO_TRABALHO,
            funcionarioId = ID,
            descricao = DESCRICAO,
            localizacao = LOCAL
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        given(lancamentoRepository.FindByFuncionarioId(ID, PageRequest.of(0, 10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
        given(lancamentoRepository.findById(ID)).willReturn(Optional.of(lancamentoMock))
        given(lancamentoRepository.save(lancamentoMock)).willReturn(lancamentoMock)
    }

    @Test
    fun TestBucarPorFuncionarioId() {
        val lancamento: Page<Lancamento>? = lancamentoServiceImpl?.bucarPorFuncionarioId(ID, PageRequest.of(0,10))
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun TestBucarPorId() {
        val lancamento: Lancamento? = lancamentoServiceImpl.buscarPorId(ID)
        Assert.assertEquals(lancamento, lancamentoMock)
    }

    @Test
    fun TestPersistir() {
        val lancamento: Lancamento? = lancamentoServiceImpl.persisitir(lancamentoMock)
        Assert.assertEquals(lancamento, lancamentoMock)
    }
}