package com.suek.nyamnyam;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService_HowtoCook {

    @GET("/HowToCook/load.php")
    Call<ArrayList<VeganItem>> loadDataFromHowToCook();
}
