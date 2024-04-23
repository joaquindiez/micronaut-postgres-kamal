package micronaut.kamal.postgresql.domain

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Serdeable
@Entity
@Table(name = "users")
data class Users(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "incrementDomain")
  @GenericGenerator(name = "incrementDomain", strategy = "increment")
  var id: Long = 0,

  @Column(name = "email")
  var email: String,
  @Column(name = "user_name")
  var userName: String? = null,


  @Column(name = "create_date")
  var createDate: LocalDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC),

  @Column(name = "update_date")
  var updateDate: LocalDateTime = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC),

)
