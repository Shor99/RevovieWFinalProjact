package or.shani.revoviewfinalprojact.service


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


//this class intercept HTTP requests
class TokenInterceptor(
    private val queryParam:String = "api_key",
    //the API key:
    private val  queryValue:String = "4f1caf3a5554aa515e41c27db9da1e92"
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val original:Request = chain.request()

        val url =
            original
            .url.newBuilder()
            .addQueryParameter(queryParam,queryValue)
            .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }

}