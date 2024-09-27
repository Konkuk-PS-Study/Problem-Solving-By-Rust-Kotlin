use std::io::{stdin, Read};
use std::fmt::Write;
use std::iter::Iterator;

fn main() {
    let mut output = String::new(); 

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<i32>);

    let n = input.next().unwrap();

    let mut countArr:[i32;8005] = [0;8005];
    let mut vec = Vec::new();

    let mut maxCount = 0;
    let mut modes = Vec::new();

    for _ in 0..n {
        let v = input.next().unwrap();
        vec.push(v);
        countArr[(v + 4000) as usize] += 1;
        if maxCount < countArr[(v + 4000) as usize] {
            modes.clear();
            modes.push(v);
            maxCount = countArr[(v + 4000) as usize];
        } else if maxCount == countArr[(v + 4000) as usize] {
            modes.push(v);
        }
    }

    vec.sort();
    modes.sort();

    let avg = (vec.iter().sum::<i32>() as f64) / (n as f64);
    let mid = vec[(n / 2) as usize];
    let mode = if modes.len() > 1 {modes[1]} else {modes[0]};
    let range = vec.iter().max().unwrap() - vec.iter().min().unwrap();

    writeln!(output, "{}", avg.round() + 1.0 - 1.0).unwrap();
    writeln!(output, "{mid}").unwrap();
    writeln!(output, "{mode}").unwrap();
    writeln!(output, "{range}").unwrap();

    println!("{output}")
}