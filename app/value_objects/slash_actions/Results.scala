package slash_actions
import models._

object Results extends SlashAction {

  def execute(
    votingSession:Option[VotingSession],
    username:String,
    data:String) = {
    if (votingSession.isDefined) {
      sendCurrentResults(votingSession.get)
    } else {
      // TODO warn that session hasn't started
    }
  }

  def sendCurrentResults(votingSession:VotingSession) = {
    val message = "NOBODY IS AGREEING"
    slack.IncomingWebhookClient.directMessage(admin, message)
  }

}