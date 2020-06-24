package com.example.testjuanfc.chat.conversation.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.testjuanfc.chat.conversation.contract.SuccessUsersListener;
import com.example.testjuanfc.chat.data.randomuser.ResultsDTO;
import com.example.testjuanfc.chat.retrofit.RetrofitAdapter;
import com.example.testjuanfc.chat.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversationViewModel extends ViewModel {

    public void getUsers(int users, SuccessUsersListener successUsersListener) {
        RetrofitAdapter retrofit = new RetrofitAdapter();
        RetrofitService service = retrofit.getAdapter().create(RetrofitService.class);

        Call<ResultsDTO> call = service.getUsers(users);
        call.enqueue(new Callback<ResultsDTO>() {
            @Override
            public void onResponse(Call<ResultsDTO> call, Response<ResultsDTO> response) {
                if (response.isSuccessful()) {
                    successUsersListener.retrieveUsers(response.body());
                } else {

                }
            }

            @Override
            public void onFailure(Call<ResultsDTO> call, Throwable t) {

            }
        });
    }
}
