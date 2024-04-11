/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChatLieuModel;
import repository.ChatLieuRepository;
import service.ChatLieuService;
import viewmodel.ChatLieuViewModel;

/**
 *
 * @author pc
 */
public class ChatLieuServiceImpl implements ChatLieuService {

    ChatLieuRepository clRepo = new ChatLieuRepository();

    @Override
    public List<ChatLieuViewModel> getAll() {
        List<ChatLieuModel> listAll = clRepo.getAll();
        List<ChatLieuViewModel> listTable = new ArrayList<>();
        for (ChatLieuModel cl : listAll) {
            listTable.add(new ChatLieuViewModel(cl.getId(), cl.getMa(), cl.getTen()));
        }
        return listTable;
    }

    @Override
    public String getAdd(ChatLieuViewModel cl) {
        ChatLieuModel clmd = new ChatLieuModel(cl.getId(), cl.getMa(), cl.getTen());
        boolean them = clRepo.getAdd(clmd);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(ChatLieuViewModel cl, int id) {
        ChatLieuModel clmd = new ChatLieuModel(cl.getId(), cl.getMa(), cl.getTen());
        boolean sua = clRepo.getUpdate(clmd,id);
        if (sua) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String getDelete(int id) {
    boolean xoa = clRepo.getDelete(id);
        if (xoa) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
