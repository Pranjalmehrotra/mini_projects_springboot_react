import { customAxios } from "./helper";

export async function sendEmailWithoutFile(emailData){

   const result =  (await customAxios.post('/email/send-html-email-single-user',emailData)).data;
     
return result;

}