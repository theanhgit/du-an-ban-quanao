/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.LoaiTheThaoModel;
import repository.LoaiTheThaoRepository;
import service.LoaiTheThaoService;
import viewmodel.LoaiTheThaoViewModel;

/**
 *
 * @author pc
 */
public class LoaiTheThaoServiceImpl implements LoaiTheThaoService {

    LoaiTheThaoRepository lttRepo = new LoaiTheThaoRepository();

    @Override
    public List<LoaiTheThaoViewModel> getAll() {
        List<LoaiTheThaoModel> listAll = lttRepo.getAll();
        List<LoaiTheThaoViewModel> listTable = new ArrayList<>();
        for (LoaiTheThaoModel ltt : listAll) {
            listTable.add(new LoaiTheThaoViewModel(ltt.getId(), ltt.getMa(), ltt.getTen()));
        }
        return listTable;
    }

    @Override
    public String getAdd(LoaiTheThaoViewModel ltt) {
        LoaiTheThaoModel lttmd = new LoaiTheThaoModel(ltt.getId(), ltt.getMa(), ltt.getTen());
        boolean them = lttRepo.getAdd(lttmd);
        if (them) {
            return "Them thanh cong";
        } else {
            return "Them that bai";
        }
    }

    @Override
    public String getUpdate(LoaiTheThaoViewModel ltt, int id) {
        LoaiTheThaoModel lttmd = new LoaiTheThaoModel(ltt.getId(), ltt.getMa(), ltt.getTen());
        boolean sua = lttRepo.getUpdate(lttmd, id);
        if (sua) {
            return "Sua thanh cong";
        } else {
            return "Sua that bai";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa = lttRepo.getDelete( id);
        if (xoa) {
            return "Xoa thanh cong";
        } else {
            return "Xoa that bai";
        }
    }

}
