package micronaut.kamal.postgresql.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import micronaut.kamal.postgresql.domain.Users

@Repository
interface UserRepository   : CrudRepository<Users, Long> {
}