use std::io::{stdin, Read};
use std::fmt::Write;
use std::iter::Iterator;

fn main() {
    let mut output = String::new(); 

    let mut input = String::new();
    stdin().read_to_string(&mut input).unwrap();
    let mut input = input.split_ascii_whitespace().flat_map(str::parse::<usize>);

    let n = input.next().unwrap();

    let max_size = n;

    let mut primes = Vec::new();
    let mut primes_map = vec![true; max_size + 1];
    primes_map[0] = false;
    primes_map[1] = false;

    for i in 2..((max_size as f64).sqrt() as usize) + 1 {
        let mut j = 2;

        while i * j <= max_size {
            primes_map[i * j] = false;

            j += 1;
        }
    }

    primes.push(0);

    for i in 2..max_size + 1 {
        if primes_map[i] {
            primes.push(i);
        }
    }

    writeln!(output, "{}", solution(n, &primes, 0, 0, 0, 0)).unwrap();

    println!("{output}")
}

fn solution(n: usize, primes: &Vec<usize>, left: usize, right: usize, sum: usize, count: usize) -> usize {
    if left >= primes.len() - 1 {
        if *primes.last().unwrap() == n {
            return count + 1;
        }
        else {
            return count;
        }
    }
    else if right >= primes.len() - 1 {
        return solution(n, primes, left + 1, right, sum - primes[left], count);
    }
    else if sum == n {
        return solution(n, primes, left, right + 1, sum + primes[right + 1], count + 1);
    }
    else if sum > n {
        return solution(n, primes, left + 1, right, sum - primes[left], count);
    }
    else {
        return solution(n, primes, left, right + 1, sum + primes[right + 1], count);
    }
}