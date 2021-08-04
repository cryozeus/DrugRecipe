package com.licious.DrugRecipe.utils;

import com.licious.DrugRecipe.dto.ResponseUtils;


import java.util.List;

public class Utils {
    public static String createMoleculeName(List<String> ingdName){
        String molName = "";
        for(int i = 0; i < ingdName.size(); i++){
            if(i != ingdName.size() - 1)
                molName += ingdName.get(i) + " + ";
            else
                molName += ingdName.get(i);
        }
        return  molName;
    }
    public static String createCompositionName(List<ResponseUtils> responseUtilsList){
         String compName="";
         for(int i = 0; i < responseUtilsList.size(); i++){
             if(i!= responseUtilsList.size() - 1){
                 compName += responseUtilsList.get(i).getName()
                         + " (" + responseUtilsList.get(i).getStrength()
                         + responseUtilsList.get(i).getUnit() + ")" + " + ";
             }
             else{
                 compName += responseUtilsList.get(i).getName()
                         + " ("+ responseUtilsList.get(i).getStrength()
                         + responseUtilsList.get(i).getUnit() + ")";
             }
         }
        return compName;
    }
}
