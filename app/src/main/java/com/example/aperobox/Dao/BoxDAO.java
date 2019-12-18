package com.example.aperobox.Dao;

import com.example.aperobox.Dao.JsonTranslator.BoxJsonTranslator;
import com.example.aperobox.Model.Box;
import com.example.aperobox.Utility.Constantes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BoxDAO {

    public ArrayList<Box> getAllBox() throws Exception {
        ArrayList<Box> boxes = new ArrayList<>();
        Gson gson = new Gson();

        URL url = new URL(Constantes.URL_API + "Box");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.setRequestProperty("Content-Type", "application/json");

        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String stringJSON = "", line;
        while ((line = buffer.readLine()) != null)
        {
            builder.append(line);
        }
        buffer.close();
        connection.disconnect();

        String inputStringJSON = builder.toString();
        JSONArray jsonArray = new JSONArray(inputStringJSON);
        for(int i = 0; i < jsonArray.length(); i++)
        {
            boxes.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Box.class));
        }

        return boxes;
    }

    public Box getBox(int id) throws Exception {
        URL url = new URL("https://aperoboxapi.azurewebsites.net/api/Box/"+id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(false);
        connection.setRequestProperty("Content-Type", "application/json");

        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String stringJSON = "", line;
        while ((line = buffer.readLine()) != null)
        {
            builder.append(line);
        }
        buffer.close();
        connection.disconnect();

        stringJSON = builder.toString();

        Box box;
        Gson object = new GsonBuilder().create();
        box = object.fromJson(stringJSON, Box.class);

        return box;

    }

    /*public Box getBox(int id) throws Exception {
        URL url = new URL(Constantes.URL_API+"Box/"+id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        if((line = buffer.readLine())!=null){
            return BoxJsonTranslator.jsonToBox(line);
        }
        return null;
    }

     */

    public List<Box> getListBox(int id) throws Exception {
        return BoxJsonTranslator.jsonToBoxes(UtilDAO.getMultipleLines(Constantes.URL_API+"Box/List/" + id));
    }

}
