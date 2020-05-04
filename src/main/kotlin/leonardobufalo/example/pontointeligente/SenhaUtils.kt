package leonardobufalo.example.pontointeligente

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBcrypt(senha: String): String {
        return BCryptPasswordEncoder().encode(senha)
    }

}