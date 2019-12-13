import okhttp3.*;

import java.io.IOException;

public class WestminsterRentalVehicleManager {

    //the base URL
    private static String url="http://localhost:8080";

    public static String viewVehicle() throws IOException {
        //OkHttp can get http requests
        OkHttpClient okHttpClient= new OkHttpClient();
        Request request=new Request.Builder().url(url+"/wesRental/vehicles").build();
        Response response = okHttpClient.newCall(request).execute();

        {
            return response.body().string(); //get the response to the console
        }
    }

    public static String searchVehicles(String id) throws IOException {
        //OkHttp can get http requests
        OkHttpClient okHttpClient= new OkHttpClient();
        Request request=new Request.Builder().url(url+"/wesRental/vehicles/"+id).build();
        Response response = okHttpClient.newCall(request).execute();

        {
            return response.body().string(); //get the response to the console
        }
    }


    public static void addCar(Car car){
        OkHttpClient okHttpClient=new OkHttpClient();

        // sending data in a json format
        String json = new StringBuilder()
                .append("{")
                .append("\"type\":\""+car.getType()+"\",")
                .append("\"plateNO\":\""+car.getPlateNO()+"\",")
                .append("\"make\":\""+car.getMake()+"\",")
                .append("\"noOfSeats\":"+car.getNoOfSeats()+",")
                .append("\"airConditioning\":"+car.isAirConditioning())
                .append("}").toString();

        // json request body
        RequestBody requestBody = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );

        //sending the request through POST method
        Request request = new Request.Builder()
                .url(url+"/wesRental")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(requestBody)
                .build();

        //getting the response
        try (Response response = okHttpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void addMotorBike(MotorBike motorBike){
        OkHttpClient okHttpClient=new OkHttpClient();

        // sending data in a json format
        String json = new StringBuilder()
                .append("{")
                .append("\"type\":\""+motorBike.getType()+"\",")
                .append("\"plateNO\":\""+motorBike.getPlateNO()+"\",")
                .append("\"make\":\""+motorBike.getMake()+"\",")
                .append("\"heightOfSeat\":"+motorBike.getHeightOfSeat()+",")
                .append("\"helmetType\":\""+motorBike.getHelmetType()+"\"")
                .append("}").toString();

        // json request body
        RequestBody requestBody = RequestBody.create(
                json,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(url+"/wesRental")
                .addHeader("User-Agent", "OkHttp Bot")
                .post(requestBody)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Get response body
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String deleteVehicles(String id) throws IOException {
        //OkHttp can get http requests
        OkHttpClient okHttpClient= new OkHttpClient();
        Request request=new Request.Builder()
                .url(url+"/wesRental/"+id)
                .delete()
                .build();
        Response response = okHttpClient.newCall(request).execute();

        {
            return response.body().string(); //get the response to the console
        }
    }


}
