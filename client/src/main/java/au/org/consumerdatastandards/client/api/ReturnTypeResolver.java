package au.org.consumerdatastandards.client.api;

import okhttp3.Response;

import java.lang.reflect.Type;

public interface ReturnTypeResolver {

    Type resolve(Response response);
}
