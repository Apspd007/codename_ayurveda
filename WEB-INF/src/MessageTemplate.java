package com.ggv.ayurveda.webutils;

public class MessageTemplate
{
    public String Message(String msg, String submsg, String href, String buttonMsg, String color)
    {
        StringBuilder template = new StringBuilder();

        //Creating Message Template
        template.append("<div class='message'>");
        template.append("<h3>"+msg+"</h3>");
        template.append("<p>"+submsg+"</p>");
        template.append("<a href='"+href+"'><button class='ok-button'>"+buttonMsg+"</button></a>");
        template.append("</div>");

        //Styling Div
        template.append("<style>");
        template.append(".message {  background-color: "+color+";  color: white;  padding: 20px;  border-radius: 5px;  text-align: center;  margin: 20px auto;  max-width: 500px; }");
        template.append(".ok-button {  background-color: white;  color: "+color+";  border: 2px solid "+color+";  border-radius: 5px;  padding: 10px 20px;  font-size: 16px;  cursor: pointer;  transition: all 0.3s ease; } ");
        template.append(".ok-button:hover {  background-color: "+color+";  color: white; }");
        template.append("</style>");

        return template.toString();
    }
}