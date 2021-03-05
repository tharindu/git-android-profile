package com.wordpress.tharindufit.gitprofile.models;

import android.util.Log;

import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller;
import com.apollographql.apollo.api.internal.ResponseWriter;
import com.wordpress.tharindufit.gitprofile.UserQuery;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Provides;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/**
 * Repository model objects represent user's git repos.
 */
public class Repository {

    private static final String TAG = Repository.class.toString();

    // owner login username
    private String login;
    // owner avatar image url
    private String avatarUrl;
    // repository name
    private String name;
    // repository description
    private String description;
    // starred count
    private int starred;
    // primary language
    private String primaryLanguage;

    @Inject
    public Repository() {

    }

    public void setData(UserQuery.Node node) {
        node.marshaller().marshal(responseWriter);
    }

    private boolean iteratingLanguage = false;

    private  ResponseWriter responseWriter = new ResponseWriter() {
        @Override
        public void writeString(@NotNull ResponseField responseField, @Nullable String s) {
            Log.d(TAG, responseField.getFieldName() + " " + responseField.getType() + " string value: " + s);
            if (responseField.getFieldName().equals("name")) {
                if (iteratingLanguage) {
                    primaryLanguage = s;
                } else {
                    name = s;
                }
                iteratingLanguage = false;
            } else if (responseField.getFieldName().equals("description")) {
                description = s;
            } else if (responseField.getFieldName().equals("login")) {
                login = s;
            } else if (responseField.getFieldName().equals("avatarUrl")) {
                avatarUrl = s;
            }
        }

        @Override
        public void writeInt(@NotNull ResponseField responseField, @Nullable Integer integer) {
            Log.d(TAG, responseField.getFieldName() + " int value: " + integer);
            if (responseField.getFieldName().equals("stargazerCount")) {
                starred = integer;
            }
        }

        @Override
        public void writeLong(@NotNull ResponseField responseField, @Nullable Long aLong) {
            Log.d(TAG, responseField.getFieldName() + " long value: " + aLong);
        }

        @Override
        public void writeDouble(@NotNull ResponseField responseField, @Nullable Double aDouble) {
            Log.d(TAG, responseField.getFieldName() + " double value: " + aDouble);
        }

        @Override
        public void writeBoolean(@NotNull ResponseField responseField, @Nullable Boolean aBoolean) {
            Log.d(TAG, responseField.getFieldName() + " int value: " + aBoolean);
        }

        @Override
        public void writeCustom(@NotNull ResponseField.CustomTypeField customTypeField, @Nullable Object o) {
            Log.d(TAG, customTypeField.getFieldName() + " obj value: " + o);
            if (customTypeField.getFieldName().equals("avatarUrl")) {
                avatarUrl = o.toString();
            }
        }

        @Override
        public void writeObject(@NotNull ResponseField responseField, @Nullable ResponseFieldMarshaller responseFieldMarshaller) {
            Log.d(TAG, responseField.getFieldName() + " marsh value: " + responseFieldMarshaller);
            if (responseField.getFieldName().equals("owner")) {
                iteratingLanguage = false;
                responseFieldMarshaller.marshal(responseWriter);
            } else if (responseField.getFieldName().equals("primaryLanguage")) {
                if (responseFieldMarshaller != null) {
                    iteratingLanguage = true;
                    responseFieldMarshaller.marshal(responseWriter);
                }
            }
        }

        @Override
        public void writeFragment(@Nullable ResponseFieldMarshaller responseFieldMarshaller) {

        }

        @Override
        public <T> void writeList(@NotNull ResponseField responseField, @Nullable List<? extends T> list, @NotNull ListWriter<T> listWriter) {
            Log.d(TAG, responseField.getFieldName() + " list value: " + list);
        }

        @Override
        public <T> void writeList(@NotNull ResponseField responseField, @Nullable List<? extends T> list, @NotNull Function2<? super List<? extends T>, ? super ListItemWriter, Unit> function2) {

        }
    };

    public void setData(UserQuery.Node1 node) {
        this.login = node.owner().login();
        this.avatarUrl = node.owner().avatarUrl().toString();
        this.name = node.name();
        this.description = node.description();
        this.starred = node.stargazerCount();
        this.primaryLanguage = (node.primaryLanguage() != null) ? node.primaryLanguage().name() : "";
    }

    public void setData(UserQuery.Node2 node) {
        this.login = node.owner().login();
        this.avatarUrl = node.owner().avatarUrl().toString();
        this.name = node.name();
        this.description = node.description();
        this.starred = node.stargazerCount();
        this.primaryLanguage = (node.primaryLanguage() != null) ? node.primaryLanguage().name() : "";
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getStarred() {
        return starred;
    }

    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

}
