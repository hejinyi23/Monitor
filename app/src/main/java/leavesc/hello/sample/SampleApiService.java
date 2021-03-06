package leavesc.hello.sample;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者：leavesC
 * 时间：2019/2/8 21:06
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
class SampleApiService {

    static HttpApi_1 getInstance_1(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(HttpApi_1.class);
    }

    static HttpApi_2 getInstance_2(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.apiopen.top")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit.create(HttpApi_2.class);
    }

    static class Data {
        final String thing;

        Data(String thing) {
            this.thing = thing;
        }
    }

    interface HttpApi_1 {

        @GET("/get")
        Call<Void> get();

        @POST("/post")
        Call<Void> post(@Body Data body);

        @PATCH("/patch")
        Call<Void> patch(@Body Data body);

        @PUT("/put")
        Call<Void> put(@Body Data body);

        @DELETE("/delete")
        Call<Void> delete();

        @GET("/status/{tv_code}")
        Call<Void> status(@Path("tv_code") int code);

        @GET("/stream/{lines}")
        Call<Void> stream(@Path("lines") int lines);

        @GET("/stream-bytes/{bytes}")
        Call<Void> streamBytes(@Path("bytes") int bytes);

        @GET("/delay/{seconds}")
        Call<Void> delay(@Path("seconds") int seconds);

        @GET("/redirect-to")
        Call<Void> redirectTo(@Query("url") String url);

        @GET("/redirect/{times}")
        Call<Void> redirect(@Path("times") int times);

        @GET("/relative-redirect/{times}")
        Call<Void> redirectRelative(@Path("times") int times);

        @GET("/absolute-redirect/{times}")
        Call<Void> redirectAbsolute(@Path("times") int times);

        @GET("/image")
        Call<Void> image(@Header("Accept") String accept);

        @GET("/gzip")
        Call<Void> gzip();

        @GET("/xml")
        Call<Void> xml();

        @GET("/encoding/utf8")
        Call<Void> utf8();

        @GET("/deflate")
        Call<Void> deflate();

        @GET("/cookies/set")
        Call<Void> cookieSet(@Query("k1") String value);

        @GET("/basic-auth/{user}/{passwd}")
        Call<Void> basicAuth(@Path("user") String user, @Path("passwd") String passwd);

        @GET("/drip")
        Call<Void> drip(@Query("numbytes") int bytes, @Query("duration") int seconds, @Query("delay") int delay, @Query("tv_code") int code);

        @GET("/deny")
        Call<Void> deny();

        @GET("/cache")
        Call<Void> cache(@Header("If-Modified-Since") String ifModifiedSince);

        @GET("/cache/{seconds}")
        Call<Void> cache(@Path("seconds") int seconds);

    }

    interface HttpApi_2 {

        @GET("/singlePoetry")
        @Headers({"testHeader" + ":" + "singlePoetry"})
        Call<String> singlePoetry();

        @GET("/recommendPoetry")
        @Headers({"testHeader" + ":" + "recommendPoetry"})
        Call<String> recommendPoetry();

        @GET("/musicBroadcasting")
        @Headers({"testHeader" + ":" + "musicBroadcasting"})
        Call<String> musicBroadcasting();

        @GET("/novelApi")
        @Headers({"testHeader" + ":" + "novelApi"})
        Call<String> novelApi();
    }

}