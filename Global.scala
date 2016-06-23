import play.api._
import play.api.mvc._
import play.api.mvc.Results._
import scala.concurrent.Future
 
object Global extends GlobalSettings {
 
 
  // 500 - internal server error
  override def onError(request: RequestHeader,ex: Throwable) = {
   Future.successful(
            InternalServerError(
                views.html.errors.fzf()
            )
   )
  }
 
  // 404 - page not found error
  override def onHandlerNotFound(request: RequestHeader)= {
   Future.successful(
           NotFound(
               views.html.errors.fzf()
               )
   )
  }
 
}
