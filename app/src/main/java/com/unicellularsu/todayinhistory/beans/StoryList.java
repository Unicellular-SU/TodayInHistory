package com.unicellularsu.todayinhistory.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by szc on 2016/11/13.
 */

public class StoryList{


    @Generated("org.jsonschema2pojo")


        @SerializedName("reason")
        @Expose
        private String reason;
        @SerializedName("result")
        @Expose
        private List<Result> result = new ArrayList<Result>();
        @SerializedName("error_code")
        @Expose
        private Integer errorCode;

        /**
         * @return The reason
         */
        public String getReason() {
            return reason;
        }

        /**
         * @param reason The reason
         */
        public void setReason(String reason) {
            this.reason = reason;
        }

        /**
         * @return The result
         */
        public List<Result> getResult() {
            return result;
        }

        /**
         * @param result The result
         */
        public void setResult(List<Result> result) {
            this.result = result;
        }

        /**
         * @return The errorCode
         */
        public Integer getErrorCode() {
            return errorCode;
        }

        /**
         * @param errorCode The error_code
         */
        public void setErrorCode(Integer errorCode) {
            this.errorCode = errorCode;
        }

    @Generated("org.jsonschema2pojo")
    public static class Result {

        @SerializedName("day")
        @Expose
        private String day;
        @SerializedName("date")
        @Expose
        private String date;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("e_id")
        @Expose
        private String eId;

        /**
         * @return The day
         */
        public String getDay() {
            return day;
        }

        /**
         * @param day The day
         */
        public void setDay(String day) {
            this.day = day;
        }

        /**
         * @return The date
         */
        public String getDate() {
            return date;
        }

        /**
         * @param date The date
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         * @return The title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return The eId
         */
        public String getEId() {
            return eId;
        }

        /**
         * @param eId The e_id
         */
        public void setEId(String eId) {
            this.eId = eId;
        }
    }
}

