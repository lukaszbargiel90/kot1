package pl.ke.luba.kot1.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import pl.ke.luba.kot1.model.User

@Repository
interface UserRepository: JpaRepository<User, Long> {
}