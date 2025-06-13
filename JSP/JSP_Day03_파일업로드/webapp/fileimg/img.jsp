<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page contentType="image/jpeg" %>
<%
    // 이미지 파일 경로
    String imagePath = application.getRealPath("/") + "WEB-INF/resources/img.jpg";

    File imgFile = new File(imagePath);

    if (imgFile.exists()) {
        try (
            FileInputStream inputStream = new FileInputStream(imgFile);
            OutputStream outputStream = response.getOutputStream();
        ) {
            byte[] buffer = new byte[1024];
            int readBytes;

            response.setContentLength((int) imgFile.length());

            while ((readBytes = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, readBytes);
            }

            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        out.println("Image file not found.");
    }
%>