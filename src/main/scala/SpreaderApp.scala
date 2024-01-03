import canoe.api._
import canoe.syntax._
import cats.effect.{IO, IOApp}
import fs2.Stream

object SpreaderApp extends IOApp.Simple {

  private val token: String = "5824728765:AAF3IWKWvnp837E4-Ne_c_5t49RBpm__eag"

  def run: IO[Unit] =
    Stream
      .resource(TelegramClient[IO](token))
      .flatMap(implicit client => Bot.polling[IO].follow(greetings))
      .compile
      .drain

  def greetings[F[_] : TelegramClient]: Scenario[F, Unit] =
    for {
        chat <- Scenario.expect(command("hi").chat)
      _ <- Scenario.eval(chat.send("Hello. What's your name?"))
      name <- Scenario.expect(text)
      _ <- Scenario.eval(chat.send(s"Nice to meet you, $name"))
    } yield ()
}