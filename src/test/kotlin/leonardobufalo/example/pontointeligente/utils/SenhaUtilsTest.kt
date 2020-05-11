package leonardobufalo.example.pontointeligente.utils

import junit.framework.Assert
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtilsTest {

    private val SENHA = "12345"
    private val bCryptEncoder = BCryptPasswordEncoder()


    @Test
    fun testGerarHashSenha() {
        val hash = SenhaUtils().gerarBcrypt(SENHA)
        Assert.assertTrue(bCryptEncoder.matches(SENHA, hash))
    }

}