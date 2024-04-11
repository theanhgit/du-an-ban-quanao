/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.KichCoModel;

import repository.KichCoRepository;
import service.KichCoService;
import viewmodel.KichCoViewModel;

/**
 *
 * @author pc
 */
public class KichCoServiceImpl implements KichCoService {

    KichCoRepository kcRepo = new KichCoRepository();

    @Override
    public List<KichCoViewModel> getAll() {
        List<KichCoModel> listAll = kcRepo.getAll();
        List<KichCoViewModel> listTable = new ArrayList<>();
        for (KichCoModel kc : listAll) {
            listTable.add(new KichCoViewModel(kc.getId(),kc.getMa(),kc.getKichCo()));
        }
        return listTable;
    }

    @Override
    public String getAdd(KichCoViewModel kc) {
        KichCoModel kcmd = new KichCoModel(kc.getId(), kc.getMa(), kc.getKichCo());
        boolean them = kcRepo.getAdd(kcmd);
        if (them) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String getUpdate(KichCoViewModel kc, int id) {
        KichCoModel kcmd = new KichCoModel(kc.getId(), kc.getMa(), kc.getKichCo());
        boolean sua = kcRepo.getUpdate(kcmd, id);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }

    @Override
    public String getDelete(int id) {
        boolean xoa = kcRepo.getDelete( id);
        if (xoa) {
            return "Xóa thành công";
        } else {
            return "Xóa thất bại";
        }
    }

}
