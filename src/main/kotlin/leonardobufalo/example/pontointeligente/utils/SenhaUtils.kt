package leonardobufalo.example.pontointeligente.utils

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SenhaUtils {

    fun gerarBcrypt(senha: String): String {
        return BCryptPasswordEncoder().encode(senha)
    }

}