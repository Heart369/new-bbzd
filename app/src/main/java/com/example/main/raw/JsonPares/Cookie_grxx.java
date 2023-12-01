package com.example.main.raw.JsonPares;

import java.util.List;

public class Cookie_grxx {

    public int retcode;
    public String message;
    public DataDTO data;

    public int getRetcode() {
        return retcode;
    }

    public String getMessage() {
        return message;
    }

    public DataDTO getData() {
        return data;
    }

    public static class DataDTO {
        public TokenDTO token;
        public UserInfoDTO user_info;

        public TokenDTO getToken() {
            return token;
        }

        public UserInfoDTO getUser_info() {
            return user_info;

        }

        public static class TokenDTO {
            public int token_type;
            public String token;

            public int getToken_type() {
                return token_type;
            }

            public String getToken() {
                return token;
            }
        }

        public static class UserInfoDTO {
            public String aid;
            public String mid;
            public String account_name;
            public String email;
            public int is_email_verify;
            public String area_code;
            public String mobile;
            public String safe_area_code;
            public String safe_mobile;
            public String realname;
            public String identity_code;
            public String rebind_area_code;
            public String rebind_mobile;
            public String rebind_mobile_time;
            public List<LinksDTO> links;

            public String getAid() {
                return aid;
            }

            public String getMid() {
                return mid;
            }

            public String getAccount_name() {
                return account_name;
            }

            public String getEmail() {
                return email;
            }

            public int getIs_email_verify() {
                return is_email_verify;
            }

            public String getArea_code() {
                return area_code;
            }

            public String getMobile() {
                return mobile;
            }

            public String getSafe_area_code() {
                return safe_area_code;
            }

            public String getSafe_mobile() {
                return safe_mobile;
            }

            public String getRealname() {
                return realname;
            }

            public String getIdentity_code() {
                return identity_code;
            }

            public String getRebind_area_code() {
                return rebind_area_code;
            }

            public String getRebind_mobile() {
                return rebind_mobile;
            }

            public String getRebind_mobile_time() {
                return rebind_mobile_time;
            }

            public List<LinksDTO> getLinks() {
                return links;
            }

            public static class LinksDTO {
                public String thirdparty;
                public String union_id;
                public String nickname;
            }
        }
    }
}
