/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigrams_cosc_620;

/**
 *
 * @author bbluebaugh
 */
public class SLListNode {
    public String data;
    public SLListNode next;
    public SLListNode(String d, SLListNode n){
            data = d;
            next = n;
    }
    private SLListNode head;//first SLL node
    private SLListNode tail;//last SLL node
}
