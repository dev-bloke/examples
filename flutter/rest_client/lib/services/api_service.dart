import 'dart:developer';

import 'package:http/http.dart' as http;
import 'package:rest_client/model/user_model.dart';

class ApiService {

  static String baseUrl = 'https://jsonplaceholder.typicode.com';
  static String usersEndpoint = '/users';

  Future<List<User>?> getUsers() async {
    List<User> _model = [];
    try {
      log("parsing...");
      var url = Uri.parse('https://jsonplaceholder.typicode.com/users');
      log("issuing request...");
      var response = await http.get(url);
      log("...done.");
      if (response.statusCode == 200) {
        _model = userFromJson(response.body);
      }
    } catch (e) {
      log("Whoops, $e");
    }
    return _model;
  }
}
