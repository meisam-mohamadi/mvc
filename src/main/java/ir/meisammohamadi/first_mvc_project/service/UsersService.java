package ir.meisammohamadi.first_mvc_project.service;

import ir.meisammohamadi.first_mvc_project.model.User;
import ir.meisammohamadi.first_mvc_project.repository.UsersRepository;
import ir.meisammohamadi.first_mvc_project.utils.Md5;

public class UsersService {

    UsersRepository repository = new UsersRepository();

    public int save(User user) {
        user.setPassword(new Md5().reciveMD5(user.getPassword()));
        return repository.save(user);
    }

    public boolean login(User user) {
        user.setPassword(new Md5().reciveMD5(user.getPassword()));
        return repository.login(user);
    }
}
