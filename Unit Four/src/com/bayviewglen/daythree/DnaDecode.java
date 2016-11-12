package com.bayviewglen.daythree;

public class DnaDecode {

	public static void main(String[] args) {
		String promoter = "TATAAT";
        String dna = "AGATTATATAATGATAGGATTTAGATTGACCCGTCATGCAAGTCCATGCATGACAGC";
        String tu = "GGATTTAGATTGACCC";
        String terminator = "";
        String done = "";
        
        int transStart = dna.indexOf("TATAAT")+10;
        
        for(int i = 0; i < tu.length(); i++){
               if (tu.charAt(i) == 'G') done += "C";
               if (tu.charAt(i) == 'A') done += "U";
               if (tu.charAt(i) == 'T') done += "A";
               if (tu.charAt(i) == 'C') done += "G";
        }
        
        System.out.print("1: " + done);

	}

}
