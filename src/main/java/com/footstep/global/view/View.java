package com.footstep.global.view;

public class View {
    public static String CERTIFICATION_SUCCESS_PAGE = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>이메일 인증 완료</title>\n" +
            "    <style>\n" +
            "\t\t.container {\n" +
            "\t\t\tmargin: auto;\n" +
            "\t\t\twidth: 80%;\n" +
            "\t\t\theight: 100vh;\n" +
            "\t\t\tdisplay: flex;\n" +
            "\t\t\tflex-direction: column;\n" +
            "\t\t\talign-items: center;\n" +
            "\t\t\tjustify-content: center;\n" +
            "\t\t\tbackground-color: #f6f6f6;\n" +
            "\t\t\tcolor: #333;\n" +
            "\t\t\tfont-family: 'Noto Sans KR', sans-serif;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.title-box {\n" +
            "\t\t\tdisplay: flex;\n" +
            "\t\t\tflex-direction: column;\n" +
            "\t\t\talign-items: center;\n" +
            "\t\t\tmargin-bottom: 30px;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.title {\n" +
            "\t\t\tfont-size: 2.5rem;\n" +
            "\t\t\tfont-weight: bold;\n" +
            "\t\t\tmargin-bottom: 10px;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.bar {\n" +
            "\t\t\theight: 4px;\n" +
            "\t\t\tbackground-color: #339AF0;\n" +
            "\t\t\twidth: 70px;\n" +
            "\t\t\tmargin-top: 5px;\n" +
            "\t\t\tmargin-bottom: 15px;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.message-box {\n" +
            "\t\t\tdisplay: flex;\n" +
            "\t\t\tflex-direction: column;\n" +
            "\t\t\talign-items: center;\n" +
            "\t\t\tmargin-bottom: 50px;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.message {\n" +
            "\t\t\tfont-size: 1.2rem;\n" +
            "\t\t\tmargin-bottom: 20px;\n" +
            "\t\t\tline-height: 1.5;\n" +
            "\t\t\ttext-align: center;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.btn-box {\n" +
            "\t\t\tdisplay: flex;\n" +
            "\t\t\tjustify-content: center;\n" +
            "\t\t\talign-items: center;\n" +
            "\t\t\tmargin: 0 auto;\n" +
            "\t\t\twidth: 100%;\n" +
            "\t\t\tmax-width: 400px;\n" +
            "\t\t}\n" +
            "\n" +
            "\t\t.btn {\n" +
            "\t\t\tcolor: #fff;\n" +
            "\t\t\tbackground-color: #6AB04A;\n" +
            "\t\t\tdisplay: inline-flex;\n" +
            "\t\t\tjustify-content: center;\n" +
            "\t\t\talign-items: center;\n" +
            "\t\t\tpadding: 12px 20px;\n" +
            "\t\t\tfont-size: 1.2rem;\n" +
            "\t\t\tletter-spacing: 1.5px;\n" +
            "\t\t\tborder-radius: 30px;\n" +
            "\t\t\tcursor: pointer;\n" +
            "\t\t\ttransition: all 0.2s ease-in-out;\n" +
            "\t\t\ttext-decoration: none;\n" +
            "\t\t}\n" +
            "\n" +
            "\t.btn:hover {\n" +
            "\t\t\tbackground-color: #4D7F2C;\n" +
            "\t\t\ttransform: scale(1.05);\n" +
            "\t\t}\n" +
            "\t</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"container\">\n" +
            "    <div class=\"title-box\">\n" +
            "        <h1 class=\"title\">이메일 인증 완료</h1>\n" +
            "        <div class=\"bar\"></div>\n" +
            "    </div>\n" +
            "    <div class=\"message-box\">\n" +
            "        <p class=\"message\">이메일 인증이 완료되었습니다!<br>인증해주셔서 감사합니다.</p>\n" +
            "    </div>\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";
}
