package micronaut.kamal.postgresql.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.serde.annotation.Serdeable
import micronaut.kamal.postgresql.domain.Users
import micronaut.kamal.postgresql.repository.UserRepository

@Serdeable
data class UserRequest ( val email : String)

@Controller("/users")
class UserController (val userRepository: UserRepository) {

  @Post
  fun addUser (@Body userRequest: UserRequest): HttpResponse<Users>{

    val newUser = Users(
      email = userRequest.email,
      userName = null
    )

    val user = userRepository.save(newUser)
    return HttpResponse.created(user)
  }

  @Get
  fun getAllUsers(): HttpResponse<List<Users>>{
    return HttpResponse.ok(userRepository.findAll())
  }
}