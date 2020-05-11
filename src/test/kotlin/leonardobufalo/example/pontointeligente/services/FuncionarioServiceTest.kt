package leonardobufalo.example.pontointeligente.services

import leonardobufalo.example.pontointeligente.utils.SenhaUtils
import leonardobufalo.example.pontointeligente.documents.Funcionario
import leonardobufalo.example.pontointeligente.enums.PerfilEnum
import leonardobufalo.example.pontointeligente.repositories.FuncionarioRepository
import leonardobufalo.example.pontointeligente.services.impl.FuncionarioServiceImpl
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class FuncionarioServiceTest {

    @InjectMocks
    private lateinit var funcionarioServiceImpl: FuncionarioServiceImpl

    @Mock
    private lateinit var funcionarioRepository: FuncionarioRepository

    val ID = "1"
    val NOME = "Teste"
    val EMAIL = "teste@teste.com"
    val CPF = "78909812300"
    val SENHA = "1234"
    val EMPRESAID = "1"

    private val funcionarioMock: Funcionario = Funcionario(
            id = ID,
            nome = NOME,
            cpf = CPF,
            email = EMAIL,
            empresaId = EMPRESAID,
            perfil = PerfilEnum.ROLE_USUARIO,
            senha = SenhaUtils().gerarBcrypt(SENHA)
    )


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        given(funcionarioRepository.save(funcionarioMock)).willReturn(funcionarioMock)
        given(funcionarioRepository.FindByEmail(EMAIL)).willReturn(funcionarioMock)
        given(funcionarioRepository.findByCpf(CPF)).willReturn(funcionarioMock)
        given(funcionarioRepository.findById(ID)).willReturn(Optional.of(funcionarioMock))

    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = funcionarioServiceImpl.persistir(funcionarioMock)
        Assert.assertEquals(funcionario, funcionarioMock)
    }

    @Test
    fun testBucarPorEmail() {
        val funcionario: Funcionario? = funcionarioServiceImpl.buscarPorEmail(EMAIL)
        Assert.assertEquals(funcionario, funcionarioMock)
    }

    @Test
    fun testBuscarPorCpf() {
        val funcionario: Funcionario? = funcionarioServiceImpl.bucarPorCpf(CPF)
        Assert.assertEquals(funcionario, funcionarioMock)
    }

    @Test
    fun testBucarPorId() {
        val funcionario: Funcionario? = funcionarioServiceImpl.buscarPorId(ID)
        Assert.assertEquals(funcionario, funcionarioMock)
    }

}

