package com.unicellularsu.todayinhistory.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by szc on 2016/11/13.
 *
 */

@Generated("org.jsonschema2pojo")
public class StoryInfo {
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
     *
     * @return
     * The reason
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     * The reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     * The result
     */
    public List<Result> getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(List<Result> result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The errorCode
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @param errorCode
     * The error_code
     */
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    @Generated("org.jsonschema2pojo")
    public static class Result {

        @SerializedName("e_id")
        @Expose
        private String eId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("picNo")
        @Expose
        private String picNo;
        @SerializedName("picUrl")
        @Expose
        private List<PicUrl> picUrl = new ArrayList<PicUrl>();

        /**
         *
         * @return
         * The eId
         */
        public String getEId() {
            return eId;
        }

        /**
         *
         * @param eId
         * The e_id
         */
        public void setEId(String eId) {
            this.eId = eId;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The content
         */
        public String getContent() {
            return content;
        }

        /**
         *
         * @param content
         * The content
         */
        public void setContent(String content) {
            this.content = content;
        }

        /**
         *
         * @return
         * The picNo
         */
        public String getPicNo() {
            return picNo;
        }

        /**
         *
         * @param picNo
         * The picNo
         */
        public void setPicNo(String picNo) {
            this.picNo = picNo;
        }

        /**
         *
         * @return
         * The picUrl
         */
        public List<PicUrl> getPicUrl() {
            return picUrl;
        }

        /**
         *
         * @param picUrl
         * The picUrl
         */
        public void setPicUrl(List<PicUrl> picUrl) {
            this.picUrl = picUrl;
        }

        @Generated("org.jsonschema2pojo")
        public static class PicUrl {

            @SerializedName("pic_title")
            @Expose
            private String picTitle;
            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("url")
            @Expose
            private String url;

            /**
             *
             * @return
             * The picTitle
             */
            public String getPicTitle() {
                return picTitle;
            }

            /**
             *
             * @param picTitle
             * The pic_title
             */
            public void setPicTitle(String picTitle) {
                this.picTitle = picTitle;
            }

            /**
             *
             * @return
             * The id
             */
            public Integer getId() {
                return id;
            }

            /**
             *
             * @param id
             * The id
             */
            public void setId(Integer id) {
                this.id = id;
            }

            /**
             *
             * @return
             * The url
             */
            public String getUrl() {
                return url;
            }

            /**
             *
             * @param url
             * The url
             */
            public void setUrl(String url) {
                this.url = url;
            }

        }

    }
}
