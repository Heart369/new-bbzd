package com.example.main.raw.JsonPares;

public class gx_json {

    public int code;
    public String message;
    public DataDTO data;

    public static class DataDTO {
        public String buildBuildVersion;
        public String forceUpdateVersion;
        public String forceUpdateVersionNo;
        public boolean needForceUpdate;
        public String downloadURL;//下载链接
        public boolean buildHaveNewVersion;
        public String buildVersionNo;
        public String buildVersion;//版本号
        public String buildDescription;
        public String buildUpdateDescription;
        public String appKey;
        public String buildKey;
        public String buildName;
        public String buildIcon;
        public String buildFileKey;
        public String buildFileSize;

        public String getDownloadURL() {
            return downloadURL;
        }

        public String getBuildVersion() {
            return buildVersion;
        }
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataDTO getData() {
        return data;
    }
}
