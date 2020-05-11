package leonardobufalo.example.pontointeligente

import leonardobufalo.example.pontointeligente.documents.Empresa
import leonardobufalo.example.pontointeligente.documents.Funcionario
import leonardobufalo.example.pontointeligente.enums.PerfilEnum
import leonardobufalo.example.pontointeligente.repositories.EmpresaRepository
import leonardobufalo.example.pontointeligente.repositories.FuncionarioRepository
import leonardobufalo.example.pontointeligente.utils.SenhaUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PontointeligenteApplication(@Autowired val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {

		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()

		val empresa: Empresa = Empresa("Empresa", cnpj = "76538372000138")
		empresaRepository.save(empresa)

		val admin: Funcionario = Funcionario(
				nome = "Admin",
				email = "admin@empresa.com",
				senha = SenhaUtils().gerarBcrypt("1234"),
				cpf = "72890765083",
				perfil = PerfilEnum.ROLE_ADMIN,
				empresaId = empresa.id!!
		)
		funcionarioRepository.save(admin)

		val funcionario: Funcionario = Funcionario(
				nome = "Funcionario 1",
				email = "funcionario@empresa.com",
				senha = SenhaUtils().gerarBcrypt("123"),
				cpf = "45338372000138",
				perfil = PerfilEnum.ROLE_USUARIO,
				empresaId = empresa.id!!
		)
		funcionarioRepository.save(funcionario)

		System.out.println("Empresa ID: " + empresa.id!!)
		System.out.println("Admin ID: " + admin.id!!)
		System.out.println("Funcionario Id: " + funcionario.id!!)
	}


}

fun main(args: Array<String>) {
	runApplication<PontointeligenteApplication>(*args)
}
