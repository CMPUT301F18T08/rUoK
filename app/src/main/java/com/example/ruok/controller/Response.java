package com.example.ruok.controller;

/**
 * @Date 2018-11-26.
 */
public interface Response<T> {
    void onSuccess(T result);

    void onError(String errorMsg);
}
